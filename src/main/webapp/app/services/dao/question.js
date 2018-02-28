import Request from '../request';

//获取问题
class QuestionService {

  getByUsername(name) {
    const request = new Request();
    return request.get('questions/user/{name}', { name });
  }

  getByTag(name) {
    const request = new Request();
    return request.get('questions/tag/{name}', { name });
  }

  get() {
    const request = new Request();
    return request.get('questions');
  }

};

export default QuestionService;
export { QuestionService };
