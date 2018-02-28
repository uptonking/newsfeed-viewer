import Request from '../request';
import APICONFIG from '../../utils/config/api-config' ;

class LatestArticleService {

  constructor() {
    this.request = new Request();
  }

  getArticleById(id) {}

  getLatest() {
    return this.getAllArticleLatest(1, APICONFIG.PAGE_SIZE_12);
  }

  getAllArticleLatest(pageNum, pageSize) {
    return this.request.get(`article/all/latest/${pageNum}/${pageSize}`);
  }

  getAllSourceCount(pageNum, pageSize) {
      return this.request.get(`article/source/all/${pageNum}/${pageSize}`);
  }

  getAllArticleBySourceName(source, pageNum, pageSize) {
      return this.request.get(`article/source/${source}/${pageNum}/${pageSize}`);

  }

  getAllTagCount(pageNum, pageSize) {
      return this.request.get(`article/tag/all/${pageNum}/${pageSize}`);
  }

  getAllArticleByTag(tag, pageNum, pageSize) {
      return this.request.get(`article/tag/${tag}/${pageNum}/${pageSize}`);
  }

}

export default LatestArticleService;
