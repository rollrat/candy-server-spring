package candy.server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CA_USER_OAUTH", schema = "PUBLIC", catalog = "TEST")
@IdClass(CaUserOauthEntityPK.class)
public class CaUserOauthEntity {
    private int oauthId;
    private int userId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OAUTH_ID")
    public int getOauthId() {
        return oauthId;
    }

    public void setOauthId(int oauthId) {
        this.oauthId = oauthId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CaUserOauthEntity that = (CaUserOauthEntity) o;
        return oauthId == that.oauthId && userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(oauthId, userId);
    }
}
