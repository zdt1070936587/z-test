package com.tianhongguoji.test.repo;

import com.tianhongguoji.test.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {
    @Query(nativeQuery = true,value = "SELECT * FROM t_user_info WHERE id = (SELECT MAX(id) FROM t_user_info)")
    UserInfo findByMaxId();
}
