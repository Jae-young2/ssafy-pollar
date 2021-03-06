package com.ssafy.pollar.model.dto;

import com.ssafy.pollar.domain.entity.Category;
import com.ssafy.pollar.domain.entity.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String uid;
    private String userId;
    private String password;
    private String userNickname;
    private String userEmail;
    private Date userBirthday;
    private Boolean userGender;
    private long followingCount;
    private long followerCount;
    private long participateVoteCount;
    private long createVoteCount;
    private String userProfilePhoto;
    private Boolean isFollow;
    @ApiModelProperty(value = "유저가 선택한 카테고리 id목록", notes="id를 이용해서 Category 테이블에서 검색")
    private List<Long> categories;
    @ApiModelProperty(value = "유저를 팔로잉한 id목록", notes="id를 이용해서 User 테이블에서 검색")
    private List<String> follower;
    @ApiModelProperty(value = "유저가 팔로우한 id목록", notes="id를 이용해서 User 테이블에서 검색")
    private List<String> followee;
    @ApiModelProperty(value = "유저가 생성한 vote id목록", notes="id를 이용해서 Vote 테이블에서 검색")
    private List<Long> createVotes;
    @ApiModelProperty(value = "유저가 투표한 vote id목록", notes="id를 이용해서 Vote 테이블에서 검색")
    private List<Long> votedVotes;
    @ApiModelProperty(value = "유저가 좋아요한 vote id목록", notes="id를 이용해서 Vote 테이블에서 검색")
    private List<Long> likedVotes;
    @ApiModelProperty(value = "유저가 작성한 reply id목록", notes="id를 이용해서 Reply 테이블에서 검색")
    private List<Long> replies;

    public UserDto(User user){
        this.userId = user.getUserId();
        this.userNickname = user.getUserNickname();
        this.userProfilePhoto = user.getUserProfilePhoto();
        this.userEmail = user.getUserEmail();
        this.userBirthday = user.getUserBirthday();
        this.userGender = user.getUserGender();
        this.userProfilePhoto = user.getUserProfilePhoto();
    }

    public UserDto(String userId,String userNickname,String userProfilePhoto){// 검색바의 유저 정보
        this.userId = userId;
        this.userNickname = userNickname;
        this.userProfilePhoto = userProfilePhoto;
    }

    public UserDto(String userId,String userNickname,String userProfilePhoto
            ,long followingCount,long followerCount,long participateVoteCount, long createVoteCount,Boolean isFollow){// 검색 결과의 유저정보
        this.userId = userId;
        this.userNickname = userNickname;
        this.userProfilePhoto = userProfilePhoto;
        this.followerCount = followerCount;
        this.participateVoteCount = participateVoteCount;
        this.createVoteCount = createVoteCount;
        this.followingCount = followingCount;
        this.isFollow = isFollow;
    }
}
