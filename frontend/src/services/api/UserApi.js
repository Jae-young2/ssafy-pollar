import { instance, instanceWithAuth, fileInstance } from '../../services/axios';
import { getLoggedUserId } from '../../utils/loggedUser';

// 공통되는 경로는 다음과 같이 별도로 정의해둠? (is this nesassary)
const USER = '/user/';

/* 아이디 중복검사 */
export const checkId = async (userId) => {
  const response = await instance.get(USER + 'idcheck', {
    params: {
      userId: userId,
    },
  });
  return response.data;
};

/* 닉네임 중복검사 */
export const checkNickname = async (userNickname) => {
  const response = await instance.get(USER + 'nickcheck', {
    params: {
      userNickname: userNickname,
    },
  });
  // console.log(response);
  return response.data;
};

/* 이메일 중복검사 */
// 여기는 왜 post일까
export const checkEmail = async (userEmail) => {
  const response = await instance.get(USER + 'emailcheck', {
    params: { 
      userEmail: userEmail 
    },
  });
  // console.log(response);
  return response.data;
};

/* 이메일 인증 메일 발송 */
export const emailConfirm = async (userEmail) => {
  // console.log(userEmail);
  const response = await instance.get(USER + 'confirmemail', {
    params: { 
      userEmail: userEmail 
    },
  });
  console.log(response.data);
  return response.data;
};

/* 이메일 인증 토큰 확인 */
export const emailToken = async (token) => {
  const response = await instance.get(USER + 'emailtoken', {
    // user 가 입력한 인증번호
    params:{
        userEmail: token.userEmail,
        token: token.token,
      }
  });
  // console.log(response);
  return response.data;
};



/* 회원정보 수정 */


// 회원 정보 얻어오기


// 프로필 이미지 수정
// ProfileApi 에서 기본 유저 정보 호출해서 사용하기
export const modifyProfilePhoto = async(formData) => {
  const response = await fileInstance.put(USER + 'photo', formData);
  console.log(response);
};
