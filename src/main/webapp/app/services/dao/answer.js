import Request from '../request';

//获取回答
class AnswerService {

  getByUsername(name) {
    const request = new Request();
    return request.get('answer/user/{name}', { name });
  }

};

export default AnswerService;
export { AnswerService };
