package com.ysmin.blog.config.auth;

import com.ysmin.blog.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


/*
 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 오나료가 되면 UserDetails 타입의 오브젝트를
 스프링 시큐리티의ㅣ 고유한 세션저장소에 저장을 해준다
 */
@Getter
public class PrincipalDetail implements UserDetails {
    private User user; // 콤포지션

    public PrincipalDetail(User user) {
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { //계정이 만료 여부를 리턴한다. (true : 만료 안됨)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //계정이 잠김 여부를 리턴한다.(true : 잠기지 않음)
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //비밀번호가 만료여부를 리턴한다. (true: 만료안됨)
        return true;
    }

    @Override
    public boolean isEnabled() { //계정 활성화(사용가능)여부 리턴한다. (true: 활성화)
        return true;
    }

    //계정이 갖고있는 권한 목록을 리턴한다. (권한이 여러개 있을 수 있어서 루프를 돌아야 하는데 우리는 한개만)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add(()-> {return "ROLE_"+user.getRole();});

        return collectors;
    }
}
