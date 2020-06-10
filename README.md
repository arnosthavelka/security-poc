# security-poc
[![Travis Build Status][travis-image]][travis-url-main] [![Sonar quality gate][sonar-quality-gate]][sonar-url] [![Sonar coverage][sonar-coverage]][sonar-url] [![Sonar bugs][sonar-bugs]][sonar-url] [![Sonar vulnerabilities][sonar-vulnerabilities]][sonar-url]

The project demonstrates several different approaches to use Spring Security (see table bellow). These approaches are usable by Spring profiles. 

## Pre-requisities
* JDK 8
* Maven 3.6
* Lombok (installed into the IDE)

## Features
- authentication (different profiles) & authorization
- JSP + JSTL
- Apache Tiles (HTML templates)
- (currently) no testing

## Profiles
| Profile name        | Type                    | Password encoder | Note             |
| ------------------- | ----------------------- | ---------------- | ----------------
| IN_MEMORY           | In-Memory               | delegating       | Default profile (no PasswordEncoder used)
| JDBC                | JDBC                    | none             | via jdbcAuthentication method (maven dependencies for embbeded DB)
| USER_DETAIL_SERVICE | JDBC                    | custom service   | via User Detail Service (maven dependencies for embbeded DB)
| APACHE_DS           | LDAP                    | native           | with Apache DS (maven dependencies for Apache DS)
| ACTIVE_DIRECTORY    | Authentication provider | native           | with Active Directory

Profile usage:
> java spring-boot:run --spring.profiles.active=JDBC

[travis-url-main]: https://travis-ci.org/arnosthavelka/security-poc
[travis-image]: https://travis-ci.org/arnosthavelka/security-poc.svg?branch=develop

[sonar-url]: https://sonarcloud.io/dashboard?id=arnosthavelka_security-poc
[sonar-quality-gate]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=alert_status
[sonar-coverage]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=coverage
[sonar-bugs]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=bugs
[sonar-vulnerabilities]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=vulnerabilities