import Request from '../request';

//获取标签
class TagService {
  get() {
    const request = new Request();
    return request.get('tags');
  }

};

export default TagService;
export { TagService };
