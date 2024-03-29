package boilerplate.pinomaker.global.domain;

import org.hibernate.annotations.Comment;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @Comment("생성 시간")
    @CreatedDate
    private LocalDateTime createdDate;

    @Comment("수정 시간")
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}