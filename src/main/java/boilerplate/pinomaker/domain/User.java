package boilerplate.pinomaker.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import boilerplate.pinomaker.common.domain.BaseTimeEntity;
import boilerplate.pinomaker.common.dto.UserAuthority;

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

    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false, length = 255)
    private String password;

    @Column(nullable = false,length = 50)
    private String name;

    @Column(nullable = false)
    private UserAuthority authority;
}
