package com.Geekster.Instagram.Backend.Design.Services;

import com.Geekster.Instagram.Backend.Design.DTO.SignInRequest;
import com.Geekster.Instagram.Backend.Design.DTO.SignUpRequest;
import com.Geekster.Instagram.Backend.Design.Models.AuthenticationToken;
import com.Geekster.Instagram.Backend.Design.Models.User;
import com.Geekster.Instagram.Backend.Design.Repositories.ITokenRepo;
import com.Geekster.Instagram.Backend.Design.Repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired
    private IUserRepo userRepo;
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private ITokenRepo tokenRepo;
    @Autowired
    private FollowerService followerService;
    @Autowired
    private FollowingService followingService;

    public ResponseEntity<String> signUp(SignUpRequest signUpRequest) {
        //Step 1.check if User already exist or not
        User user = userRepo.findFirstByEmail(signUpRequest.getEmail());

        //Step 2.if user is not equals null ,this means user with this email already exists in the database
        if (user != null) {
            throw new IllegalStateException("User with this email already exist..try sign-in");
        }
        //Step 3.Encryption of password
        String hashedPassword = DigestUtils.md5DigestAsHex(signUpRequest.getPassword().getBytes());

        //Step 4.save the user as a new instagram user
        user = new User(
                signUpRequest.getFirstName(),
                signUpRequest.getLastName(),
                signUpRequest.getInstagramName(),
                signUpRequest.getInstagramBio(),
                signUpRequest.getEmail(),
                signUpRequest.getDateOfBirth(),
                hashedPassword,
                signUpRequest.getPhoneNumber()
        );
        //Step 5. save instagram user in database
        userRepo.save(user);

        return new ResponseEntity<>("User registered successfully..Thank you!!", HttpStatus.OK);
    }

    public ResponseEntity<String> signIn(SignInRequest signInRequest) {
        //Step 1.Get user email and check if it's already there in the database or not
        User user =userRepo.findFirstByEmail(signInRequest.getEmail());

        //Step 2.if user is null it means there is no user registered with this email
        if(user == null){
            throw new IllegalStateException("No user is registered with this email..try sign-up!!");
        }
        //Step 3.Encrypt the user password to check if this encrypted password is exists in the database
        String encryptedPass = DigestUtils.md5DigestAsHex(signInRequest.getPassword().getBytes());

        //Step 4.Match it with already existing passwords
        boolean isPasswordValid = encryptedPass.equals(user.getPassword());

        //Step 5.if it is not valid throw exception
        if(!isPasswordValid){
            throw new IllegalStateException("User Invalid..try sign-in again!!");
        }

        //Step 6.Create and save token corresponds to this user
        AuthenticationToken token = new AuthenticationToken(user);
        authenticationService.saveToken(token);

        //Step 7. figure out the token
        AuthenticationToken authenticationToken = authenticationService.getToken(user);

        return new ResponseEntity<>(authenticationToken.getToken(), HttpStatus.ACCEPTED);
    }

    public void updateUser(SignUpRequest updateUserRequest, String token) {
        User originalUser = tokenRepo.findFirstByToken(token).getUser();
        if(!(updateUserRequest.getFirstName().isEmpty())){
            originalUser.setFirstName(updateUserRequest.getFirstName());
        }
        if((updateUserRequest.getLastName()!=null)){
            originalUser.setLastName(updateUserRequest.getLastName());
        }
        if((updateUserRequest.getPassword()!=null)){
            String encryptedPassword = null;
            try {
                encryptedPassword = DigestUtils.md5DigestAsHex(updateUserRequest.getPassword().getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            originalUser.setPassword(encryptedPassword);
        }
        if((updateUserRequest.getPhoneNumber()!=null)){
            Pattern p = Pattern.compile("\\d{2}-\\d{10}");
            Matcher m = p.matcher(updateUserRequest.getPhoneNumber());
            if( (m.find() && m.group().equals(updateUserRequest.getPhoneNumber()))){
                originalUser.setPhoneNumber(updateUserRequest.getPhoneNumber());
            }else{
                throw new IllegalStateException("Enter correct details..!!");
            }
        }
        if((updateUserRequest.getEmail()!=null)){
            Pattern p = Pattern.compile("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}");
            Matcher m = p.matcher(updateUserRequest.getEmail());
            if( (m.find() && m.group().equals(updateUserRequest.getEmail()))){
                originalUser.setEmail(updateUserRequest.getEmail());
            }else{
                throw new IllegalStateException("Enter correct details");
            }
        }
        userRepo.save(originalUser);
    }

    public String followUser(Long myId, Long otherId) {
        if(Objects.equals(myId, otherId)){
            return "Cant follow yourself!!!!";
        }
        User myUser = userRepo.findByUserId(myId);
        User otherUser = userRepo.findByUserId(otherId);
        if(myUser!=null && otherUser!=null) {
            //follow from my side
            followingService.saveFollowing(myUser,otherUser);
            //follower from other side
            followerService.saveFollower(otherUser, myUser);
            return "Followed Successfully!!!!!";
        }else{
            return "Users are invalid!!!";
        }
    }

    public String toggleBlueTick(Long id, boolean blueTick) {
        User user = userRepo.findByUserId(id);
        if(user!=null) {
            user.setBlueTicked(blueTick);
            userRepo.save(user);
            return "Blue tick was set to.." + blueTick;
        } else {
            return "user doesn't exist";
        }
    }
}
