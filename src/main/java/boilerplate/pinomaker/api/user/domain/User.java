package boilerplate.pinomaker.api.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import boilerplate.pinomaker.global.domain.BaseTimeEntity;
import boilerplate.pinomaker.global.dto.UserAuthority;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_idx")
    private Long idx;

    @Comment("아이디")
    @Column(unique = true, nullable = false)
    private String id;

    @Comment("비밀번호")
    @Column(nullable = false, length = 255)
    private String password;

    @Comment("이름")
    @Column(nullable = false,length = 50)
    private String name;

    @Comment("권한")
    @Column(nullable = false)
    private UserAuthority authority;
}
