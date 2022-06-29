package cn.edu.guet.service.impl;

import cn.edu.guet.mapper.RoleMapper;
import cn.edu.guet.mapper.RolePermissionMapper;
import cn.edu.guet.mapper.UserRoleMapper;
import cn.edu.guet.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLSyntaxErrorException;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    @Transactional(noRollbackFor = RuntimeException.class)
    public int deleteRoleById(String roleId) {
        rolePermissionMapper.deleteRolePermission(roleId);//成功

        userRoleMapper.deleteUserRole(roleId);//成功

        /*
        Spring事务管理，默认针对运行时异常回滚
         */
        int a=3;
        if(a==3){
            throw new RuntimeException("ddddd");
        }
        roleMapper.deleteRoleById(roleId);//失败



        return 0;
    }
}
