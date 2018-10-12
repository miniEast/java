package com.springdata.jpa;

import com.springdata.jpa.dao.*;
import com.springdata.jpa.pojo.Menus;
import com.springdata.jpa.pojo.Roles;
import com.springdata.jpa.pojo.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaApplicationTests {
    @Autowired
    private UsersRepostory usersRepostory;

    @Autowired
    private UsersRepositoryByName usersRepositoryByName;

    @Autowired
    private UsersrRepositoryQueryAnnotation usersrRepositoryQueryAnnotation;

    @Autowired
    private UsersCRUDRepostory usersCRUDRepostory;


    @Autowired
    private UsersPageRepostory usersPageRepostory;

    @Autowired
    private UsersRepostorycificationExcecutor usersRepostorycificationExcecutor;


    @Autowired
    private RolesRepoctory rolesRepoctory;

    /**
     * 测试JPA
     */
    @Test
    public void testJpaSave() {
        Users users = new Users();
        users.setAddress("汉娜珍兽");
        users.setAge(18);
        users.setName("李二毛");
        usersRepostory.save(users);
    }

    /**
     * 测试JPA
     */
    @Test
    public void testJpaSaveCRUD() {
        Users users = new Users();
        users.setAddress("汉娜珍兽");
        users.setAge(18);
        users.setName("李媛媛");
        usersCRUDRepostory.save(users);
    }

    /**
     * 测试JPA  修改也用save 传主键
     */
    @Test
    public void testJpaUpdateCRUD() {
        Users users = new Users();
        users.setAddress("许昌老剑姬");
        users.setAge(18);
        users.setName("枫成为");
        users.setId(3);
        usersCRUDRepostory.save(users);
    }

    /**
     * 测试JPA
     */
    @Test
    public void testJpaFindByName() {

        List<Users> 风二球 = usersRepositoryByName.findByNameAndAge("风二球", 18);
        for (Users user :
                风二球) {
            System.out.println(user);

        }
    }

    /**
     * 测试JPA
     */
    @Test
    public void testJpaFindByNameLike() {

        List<Users> 风二球 = usersRepositoryByName.findByNameLike("%五%");
        for (Users user :
                风二球) {
            System.out.println(user);

        }
    }

    /**
     * 测试JPA  Query  HQL
     */
    @Test
    public void testJpaFindByNameQueryHql() {

        List<Users> users = usersrRepositoryQueryAnnotation.queryByNameUseHql("王五");
        for (Users user :
                users) {
            System.out.println(user);

        }
    }

    /**
     * 测试JPA  Query SQL
     */
    @Test
    public void testJpaFindByNameQuerySql() {

        List<Users> users = usersrRepositoryQueryAnnotation.queryByNameUseSql("李二毛");
        for (Users user :
                users) {
            System.out.println(user);

        }
    }

    /**
     * 测试JPA  Query HQL  双参数
     */
    @Test
    @Transactional
    @Rollback(value = false) //test 中使用 事物自动回滚
    public void testJpaFindByNameQueryHql2() {
        usersrRepositoryQueryAnnotation.updateUserNameByUserId("王春阳", 2);
    }


    /**
     * 排序
     */
    @Test
    public void testJpaSort() {

        Order order = new Order(Sort.Direction.DESC, "id");
        Sort sort = new Sort(order);
        Iterable<Users> all = usersPageRepostory.findAll(sort);

        for (Users user :
                all) {
            System.out.println(user);

        }
    }


    /**
     * 分页
     */
    @Test
    public void testJpaPage() {

//        分页参数 当前页 每页显示的条数 从0开始  页码      页面容量
        Pageable pageable = new PageRequest(1, 2);

        Page<Users> all = usersPageRepostory.findAll(pageable);

        System.out.println("总条数：" + all.getTotalElements());
        System.out.println("总页数：" + all.getTotalPages());


        for (Users user :
                all.getContent()) {
            System.out.println(user);

        }
    }


    /**
     * 分页+排序
     */
    @Test
    public void testJpaPageAndSort() {

        Sort sort = new Sort(new Order(Sort.Direction.DESC, "id"));

//        分页参数 当前页 每页显示的条数 从0开始  页码      页面容量
        Pageable pageable = new PageRequest(1, 2, sort);

        Page<Users> all = usersPageRepostory.findAll(pageable);

        System.out.println("总条数：" + all.getTotalElements());
        System.out.println("总页数：" + all.getTotalPages());


        for (Users user :
                all.getContent()) {
            System.out.println(user);

        }
    }

    /**
     * 单条件使用
     */
    @Test
    public void spacificationExecutor1() {

        Specification<Users> specification = new Specification<Users>() {

//            Predicate  封装了查询条件

            /**
             *
             * @param root 查询 对象属性的封装
             * @param criteriaQuery  封装了要执行的哥哥部分信息 sselect *from order
             * @param cb  cb 条件构造器 带定义不同查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
//   wwhere name =

                /**
                 * 参数一 条件
                 * 条件而 条件值
                 */
                Predicate equal = cb.equal(root.get("name"), "王春阳");


                return equal;
            }
        };
        List<Users> all = usersRepostorycificationExcecutor.findAll(specification);

        for (Users users : all) {
            System.out.println(users);
        }

    }

    /**
     * 多条件使用
     */
    @Test
    public void spacificationExecutor2() {

        Specification<Users> specification = new Specification<Users>() {

//            Predicate  封装了查询条件

            /**
             *
             * @param root 查询 对象属性的封装
             * @param criteriaQuery  封装了要执行的哥哥部分信息 sselect *from order
             * @param cb  cb 条件构造器 带定义不同查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
//   wwhere name =

                /**
                 * 参数一 条件
                 * 条件而 条件值
                 */

                List<Predicate> predicateList = new ArrayList<>();
                predicateList.add(cb.equal(root.get("name"), "王春阳"));
                predicateList.add(cb.equal(root.get("age"), 18));

                Predicate[] predicatesArr = new Predicate[predicateList.size()];
                cb.and(predicateList.toArray(predicatesArr));

                return cb.and(predicateList.toArray(predicatesArr));
            }
        };
        List<Users> all = usersRepostorycificationExcecutor.findAll(specification);

        for (Users users : all) {
            System.out.println(users);
        }

    }

    /**
     * 多条件使用 2
     */
    @Test
    public void spacificationExecutor3() {

        Specification<Users> specification = new Specification<Users>() {

//            Predicate  封装了查询条件

            /**
             *
             * @param root 查询 对象属性的封装
             * @param criteriaQuery  封装了要执行的哥哥部分信息 sselect *from order
             * @param cb  cb 条件构造器 带定义不同查询条件
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
//   wwhere name =

                /**
                 * 参数一 条件
                 * 条件而 条件值
                 */

//                List<Predicate> predicateList = new ArrayList<>();
//                predicateList.add(cb.equal(root.get("name"), "王春阳"));
//                predicateList.add(cb.equal(root.get("age"), 18));
//
//                Predicate[] predicatesArr = new Predicate[predicateList.size()];
//                cb.and(predicateList.toArray(predicatesArr));

                return cb.or(cb.and(cb.equal(root.get("name"), "王春阳"), cb.equal(root.get("age"), 18)), cb.equal(root.get("id"), 1));
            }
        };
        Sort sort = new Sort(new Order(Sort.Direction.DESC, "id"));
        List<Users> all = usersRepostorycificationExcecutor.findAll(specification, sort);

        for (Users users : all) {
            System.out.println(users);
        }

    }

//    测试关联关系


    /**
     * 一对多
     * <p>
     * 添加
     */
    @Test
    public void cahainTS() {
//        创建一个用户


        Users users = new Users();
        users.setAddress("咸阳大寨");
        users.setAge(22);
        users.setName("张瑞");


//        创建一个角色

        Roles roles = new Roles();
        roles.setRoleName("草鸡管理员");

//        关联

        roles.getUsersSet().add(users);
        users.setRoles(roles);

//        保存
        usersRepostory.save(users);

    }

    /**
     * 多对多
     * <p>
     * 查询
     */
    @Test
    public void DT() {

//        保存
        Users one = usersRepostory.findOne(6);
        System.out.println(one);

        System.out.println(one.getRoles().getRoleName());

    }

    /**
     * 一对多
     * <p>
     * 添加
     */
    @Test
    public void DS() {


        Roles roles = new Roles();
        roles.setRoleName("PM");

        Menus menus = new Menus();
        menus.setFatherId(-1);
        menus.setMenuName("添加人员");

        Menus menu2 = new Menus();
        menu2.setFatherId(1);
        menu2.setMenuName("人员管理");
        menu2.setMenuUrl("/url/uu");

        roles.getMenus().add(menu2);
        roles.getMenus().add(menus);

        menus.getRoles().add(roles);
        menu2.getRoles().add(roles);


//        保存
        rolesRepoctory.save(roles);

    }

    /**
     * 一对多
     * <p>
     * 查询
     */
    @Test
    public void DTD() {

//        保存
        Roles one = rolesRepoctory.findOne(2);
        System.out.println(one);

        for (Menus menu : one.getMenus()) {
            System.out.println(menu);
        }

    }


}
