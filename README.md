# security-poc
[![Travis Build Status][travis-image]][travis-url-main] [![Sonar quality gate][sonar-quality-gate]][sonar-url] [![Sonar coverage][sonar-coverage]][sonar-url] [![Sonar bugs][sonar-bugs]][sonar-url] [![Sonar vulnerabilities][sonar-vulnerabilities]][sonar-url]

POC of Spring Security usage with these features:
- based on Spring Boot 1.3 & Java 8 (TOBE updated soon)
- authentication (different profiles) & authorization
- JSP + JSTL
- Apache Tiles (templating)
- (currently) no testing

POC contains several Spring profiles to demonstrate several different configuration options (see table bellow).

Profile name | Type | Note
------------- | ------------- | -------------
IN_MEMORY | **In-Memory** | Default profile
JDBC | JDBC  | via jdbcAuthentication method (maven dependencies for embbeded DB)
USER_DETAIL_SERVICE | JDBC  | via User Detail Service (maven dependencies for embbeded DB)
APACHE_DS | LDAP  | with Apache DS (maven dependencies for Apache DS)
ACTIVE_DIRECTORY | Authentication provider | with Active Directory

Profile usage:
> java spring-boot:run --spring.profiles.active=JDBC

[travis-url-main]: https://travis-ci.org/arnosthavelka/security-poc
[travis-image]: https://travis-ci.org/arnosthavelka/security-poc.svg?branch=develop

[sonar-url]: https://sonarcloud.io/dashboard?id=arnosthavelka_security-poc
[sonar-quality-gate]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=alert_status
[sonar-coverage]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=coverage
[sonar-bugs]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=bugs
[sonar-vulnerabilities]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=vulnerabilities