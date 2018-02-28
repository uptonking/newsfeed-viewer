import $ from 'jquery';

//请求工具类get+post
class Request {

  constructor() {
    this.apikey = '123';
    this.baseUrl = `${window.config.basename}/api/`;
  }

  /**
  *请求参数对象转字符串
   * serialize Object into a list of parameters
   * ex. obj { token: 12345, action: login } => token=12345&action=login
   */
  static getParams(o) {
    return Object.keys(o).map(key => `${key}=${encodeURIComponent(o[key])}`).join('&');
  }

  /**
  *请求参数对象转路径参数
   * replace params from Object in passed string variable  to path
   * ex. str: "match/{id}", params: {id:5} => "match/5"
   */
  static replaceParams(str, params = {}) {
    for (const prop of Object.keys(params)) {
      str = str.replace(`{${prop}}`, params[prop]);
    }
    return str;
  }

  /**
  *拼凑请求url，发起ajax请求，返回Promise对象
   * get request to API with params
   */
  static request(url, params = false, data, { type }) {
    const paramsString = params ? Request.getParams(params) : '';
    const urlWithParams = `${url}?${paramsString}`;

    console.log(`api request to ${urlWithParams}`);

    data = data ? JSON.stringify(data) : false;

    return new Promise((resolve, reject) => {
      $.ajax({
        url: urlWithParams,
        type,
        dataType: 'json',
        data,
        contentType: 'application/json',
        success: data => {
          resolve(data);
        },
        error: (xhr, status, err) => {
          console.error(urlWithParams, status, err.toString());
        }
      })

      // request(urlWithParams, (error, response, body) => {
      //   const { statusCode } = response;
      //   // handle error
      //   if (error || statusCode < 200 || statusCode > 299) {
      //     reject(new Error(`Failed to load page with status code: ${response.statusCode}`));
      //   }
      //   resolve(body);
      // });
    });
  }

  /**
  * get请求
   * public method for get data from api
   */
  get(resource, options = {}, data = false) {
    return new Promise((resolve, reject) => {
      // add api_token to request
      const params = { api_token: this.apikey };

    //   拼凑请求url
      const url = this.baseUrl + Request.replaceParams(resource, options);

      Request.request(url, params, data, { type: 'GET' })
      .then(result => resolve(result))
      .catch(error => reject(error));
    });
  }

  /**
  *post请求
   * public method for get data from api
   */
  post(resource, options = {}, data = false) {
    return new Promise((resolve, reject) => {
      // add api_token to request
      const params = { api_token: this.apikey };
      const url = this.baseUrl + Request.replaceParams(resource, options);

      Request.request(url, params, data, { type: 'POST' })
      .then(result => resolve(result))
      .catch(error => reject(error));
    });
  }
}

export default Request;
export { Request };
