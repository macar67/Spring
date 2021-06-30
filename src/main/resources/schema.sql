DROP TABLE IF EXISTS `user`;
CREATE TABLE user
(
  id              INT unsigned NOT NULL AUTO_INCREMENT,
  username            VARCHAR(150) NOT NULL,
  password           VARCHAR(150) NOT NULL,
    PRIMARY KEY     (id)
);

DROP TABLE IF EXISTS `log`;
CREATE TABLE log

(
  id              INT unsigned NOT NULL AUTO_INCREMENT,
  info            VARCHAR(150) ,
    PRIMARY KEY     (id)
);

DROP TABLE IF EXISTS `route`;
CREATE TABLE route
(
  routeid         INT unsigned NOT NULL AUTO_INCREMENT,
  name            VARCHAR(150) ,
  stationnumber   INT unsigned ,
  PRIMARY KEY     (routeid)
);

DROP TABLE IF EXISTS `transports`;
CREATE TABLE transports
(
  transportsid         INT unsigned NOT NULL AUTO_INCREMENT,
  name            VARCHAR(150) NOT NULL,
  speed           INT unsigned,
  capacity      VARCHAR(150) ,
  plate         VARCHAR(150) NOT NULL,
  routeid        INT unsigned,
  PRIMARY KEY     (transportsid)
);

DROP TABLE IF EXISTS `stations`;
CREATE TABLE stations
(
  stationid       INT unsigned NOT NULL AUTO_INCREMENT,
  name            VARCHAR(150) NOT NULL,
  isactive        BOOLEAN,

  PRIMARY KEY     (stationid)
);

DROP TABLE IF EXISTS `routestationmap`;
CREATE TABLE routestationmap
(
  id              INT unsigned NOT NULL AUTO_INCREMENT,
  route           INT unsigned,
  station         INT unsigned,

  PRIMARY KEY     (id)
);
