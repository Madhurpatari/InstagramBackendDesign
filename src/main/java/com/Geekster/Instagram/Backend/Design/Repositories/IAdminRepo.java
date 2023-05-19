package com.Geekster.Instagram.Backend.Design.Repositories;

import com.Geekster.Instagram.Backend.Design.Models.Admin;
import com.Geekster.Instagram.Backend.Design.Models.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<Admin, Long> {
}
