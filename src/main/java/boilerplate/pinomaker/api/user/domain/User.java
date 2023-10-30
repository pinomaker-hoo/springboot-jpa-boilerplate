package boilerplate.pinomaker.api.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import boilerplate.pinomaker.global.domain.BaseTimeEntity;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Table(name = "TB_USER")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Comment("아이디")
    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Comment("비밀번호")
    @Column(nullable = false, length = 255)
    private String password;

    @Comment("이름")
    @Column(nullable = false,length = 50)
    private String name;
}
