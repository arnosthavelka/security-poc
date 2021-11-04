# security-poc
[![Travis Build Status][travis-image]][travis-url-main] [![Sonar quality gate][sonar-quality-gate]][sonar-url] [![Sonar coverage][sonar-coverage]][sonar-url] [![Sonar bugs][sonar-bugs]][sonar-url] [![Sonar vulnerabilities][sonar-vulnerabilities]][sonar-url] [![MIT licensed][mit-badge]](./LICENSE.txt)

The project demonstrates several different approaches to use Spring Security (see table bellow). These approaches are usable by Spring profiles. 

## Pre-requisities
* JDK 17
* Maven 3.8

## Features
- authentication (different profiles) & authorization
- JSP + JSTL
- Apache Tiles (HTML templates)
- Actuator
- (currently) no testing -> therefore quality gate is failing

## Profiles
| Type                    | Maven Profile       | Spring Profile          | Password encoder | Note             |
| ----------------------- | ------------------- | ----------------------- | ---------------- | ----------------
| In-Memory (default)     | MEM                 | IN_MEMORY               | delegating       | Default profile (no PasswordEncoder used)
| Database                | DB                  | JDBC                    | none             | via jdbcAuthentication method (maven dependencies for embbeded DB)
| Custom service          | USER_SERVICE        | USER_DETAIL_SERVICE     | custom service   | via User Detail Service (maven dependencies for embbeded DB)
| LDAP                    | LDAP                | LDAP                    | BCrypt hashing   | with UnboundId
| Authentication provider | AD                  | AD                      | native           | with Active Directory

Profile usage:
> java spring-boot:run --spring.profiles.active=JDBC

[travis-url-main]: https://app.travis-ci.com/github/arnosthavelka/security-poc
[travis-image]: https://travis-ci.com/arnosthavelka/security-poc.svg?branch=develop

[sonar-url]: https://sonarcloud.io/dashboard?id=arnosthavelka_security-poc
[sonar-quality-gate]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=alert_status
[sonar-coverage]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=coverage
[sonar-bugs]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=bugs
[sonar-vulnerabilities]: https://sonarcloud.io/api/project_badges/measure?project=arnosthavelka_security-poc&metric=vulnerabilities
[mit-badge]: https://img.shields.io/badge/license-MIT-maroon.svg
