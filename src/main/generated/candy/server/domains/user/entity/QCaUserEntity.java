package candy.server.domains.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCaUserEntity is a Querydsl query type for CaUserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCaUserEntity extends EntityPathBase<CaUserEntity> {

    private static final long serialVersionUID = -933650987L;

    public static final QCaUserEntity caUserEntity = new QCaUserEntity("caUserEntity");

    public final ListPath<CaUserLoginEntity, QCaUserLoginEntity> caUserLoginEntityList = this.<CaUserLoginEntity, QCaUserLoginEntity>createList("caUserLoginEntityList", CaUserLoginEntity.class, QCaUserLoginEntity.class, PathInits.DIRECT2);

    public final ListPath<CaUserRoleEntity, QCaUserRoleEntity> caUserRoleEntityList = this.<CaUserRoleEntity, QCaUserRoleEntity>createList("caUserRoleEntityList", CaUserRoleEntity.class, QCaUserRoleEntity.class, PathInits.DIRECT2);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userIdid = createString("userIdid");

    public final DateTimePath<java.sql.Timestamp> userLastLoginTime = createDateTime("userLastLoginTime", java.sql.Timestamp.class);

    public final StringPath userNickname = createString("userNickname");

    public final StringPath userPw = createString("userPw");

    public final NumberPath<Integer> userRest = createNumber("userRest", Integer.class);

    public final DateTimePath<java.sql.Timestamp> userSignupTime = createDateTime("userSignupTime", java.sql.Timestamp.class);

    public QCaUserEntity(String variable) {
        super(CaUserEntity.class, forVariable(variable));
    }

    public QCaUserEntity(Path<? extends CaUserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCaUserEntity(PathMetadata metadata) {
        super(CaUserEntity.class, metadata);
    }

}

