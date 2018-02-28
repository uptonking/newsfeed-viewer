# News Feeds View

Very light version of [Feedly](https://feedly.com) build by ReactJS(client-side) and Spring(server-side).

## Features

- [x] Latest news feeds about tech, products & marketing
- [x] Localization in react using [localizify](https://github.com/noveogroup-amorgunov/localizify)
- [x] Authorization system using [json web token](https://jwt.io)

- [ ] news star
- [ ] add tags
- [ ] left side drag & drop
- [ ] left side simple filter
- [ ] right side tag billboard


## Intallation

**0** git clone
**1** Change database driver (by default set for MySQL) and connections parameters (url, user and password) in `src/main/resources/app.properties`
**2** Change `jwt` secret key in `src/main/resources/app.properties` too (not nessasary)
**3** Create schema. After run application table will be created in auto mode. Follow example for MySQL

```sql
CREATE SCHEMA `news_feeds` DEFAULT CHARACTER SET utf8 ;
```

**4** Install and build frontend dependencies

```shell
$ cd src/main/webapp
$ npm install
$ npm install webpack -g
$ npm run build
```

Use `npm run watch` for work in watch-mode. When you change some javascript file, here will be build new bundle.js

**5** Run server

```shell
$ mvn tomcat7:run
```

open [http://localhost:8491](http://localhost:8491)
