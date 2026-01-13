package com.project.greenated.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.greenated.model.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	@Query("SELECT u FROM Users u WHERE u.email = :username")
	Users findByUsername(@Param("username") String username);

	@Query("SELECT u FROM Users u " + "LEFT JOIN FETCH u.roles r " + "LEFT JOIN FETCH r.rolePermissions rp "
			+ "LEFT JOIN FETCH rp.permission p " + "WHERE u.email = :username AND u.password = :password")
	List<Users> loadUserDetails(@Param("username") String username, @Param("password") String password);

	@Query(value = "SELECT u.* FROM users u JOIN roles r ON u.role_id=r.role_id " +
		            "WHERE (u.parent_id=:parentId OR u.parent_id IN " +
		            "(SELECT user_id FROM users WHERE parent_id=:parentId)) " +
		            "AND r.role_name=:roleName", nativeQuery = true)
	List<Users> findUsersByParentAndRoleName(@Param("parentId") Integer parentId, @Param("roleName") String roleName);

	// Get root users (no parent)
	List<Users> findByParentIsNull();
}
