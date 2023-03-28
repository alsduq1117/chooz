package com.cdg.chooz.entity.user;

import com.cdg.chooz.domain.user.User;
import com.cdg.chooz.entity.common.BaseTimeEntity;
import com.cdg.chooz.domain.user.Providers;
import com.cdg.chooz.domain.user.Role;
import com.cdg.chooz.domain.vote.AgeType;
import com.cdg.chooz.domain.vote.GenderType;
import com.cdg.chooz.domain.vote.MbtiType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class UserEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column
    private String nickname;

    @Column
    private String email;

    private String imageUrl;

    private String password;

    @Enumerated(EnumType.STRING)
    private Providers provider;    // oauth2를 이용할 경우 어떤 플랫폼을 이용하는지

    private String providerId;  // oauth2를 이용할 경우 아이디값

    @Enumerated(EnumType.STRING)
    private Role role;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @Enumerated(EnumType.STRING)
    private MbtiType mbti;

    @Column(name = "modified_MBTI_Date")
    private LocalDateTime modifiedMBTIDate;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
//    @JoinColumn(name = "USER_ID")
//    private List<CategoryEntity> categoryLists = new ArrayList<>();
//
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<Bookmark> bookmarkList = new ArrayList<>();
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
//    private List<CommentEmotion> commentEmotionList = new ArrayList<>();


//    public void mappingCommentLike(CommentEmotion commentEmotion) {
//        this.commentEmotionList.add(commentEmotion);
//    }
//
//    public void mappingBookmark(Bookmark bookmark) {
//        this.bookmarkList.add(bookmark);
//    }

    public void updateProfile(String nickname, String image) {
        this.nickname = nickname;
        this.imageUrl = image;
    }

    public void updateMbti(MbtiType mbti, LocalDateTime modifiedMBTIDate) {
        this.mbti = mbti;
        this.modifiedMBTIDate = modifiedMBTIDate;
    }
    public AgeType classifyAge(Integer age) {
        AgeType ageGroup;
        switch (age / 10) {
            case 1:
                ageGroup = AgeType.teenager;
                break;
            case 2:
                ageGroup = AgeType.twenties;
                break;
            case 3:
                ageGroup = AgeType.thirties;
                break;
            case 4:
                ageGroup = AgeType.fourties;
                break;
            case 5:
                ageGroup = AgeType.fifties;
                break;
            default:
                ageGroup = AgeType.NULL;
                break;
        }
        return ageGroup;
    }

//    public void clearCategoryList() {
//        this.categoryLists.clear();
//    }

    public UserEntity(Long id, String nickname, String email, String imageUrl, String password, Providers provider, String providerId, Role role, Integer age, GenderType gender, MbtiType mbti, LocalDateTime modifiedMBTIDate) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.imageUrl = imageUrl;
        this.password = password;
        this.provider = provider;
        this.providerId = providerId;
        this.role = role;
        this.age = age;
        this.gender = gender;
        this.mbti = mbti;
        this.modifiedMBTIDate = modifiedMBTIDate;
    }

    public static UserEntity from(User user) {
        if(user.getId() == null){
            return new UserEntity(null,user.getNickname(),user.getEmail(),user.getImageUrl(),user.getPassword(),user.getProvider(),user.getProviderId(),user.getRole(),user.getAge(),user.getGender(),user.getMbti(),user.getModifiedMBTIDate());
        }
        return new UserEntity(user.getId(),user.getNickname(),user.getEmail(),user.getImageUrl(),user.getPassword(),user.getProvider(),user.getProviderId(),user.getRole(),user.getAge(),user.getGender(),user.getMbti(),user.getModifiedMBTIDate());
    }



    public User toDomain() {
        return new User(id,nickname,email,imageUrl,password,provider,providerId,role,age,gender,mbti,modifiedMBTIDate);
    }

}
