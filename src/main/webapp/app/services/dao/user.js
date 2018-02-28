import Request from '../request';

//用户信息获取 + 修改密码
class UserService {
  getByUsername(name) {
    const request = new Request();
    return request.get('users/name/{username}', { username: name });
  }

  changePassword(data) {
    const request = new Request();
    return request.post('user/changepassword', {}, data);
  }

};

export default UserService;
export { UserService };
