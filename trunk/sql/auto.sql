DROP DATABASE IF EXISTS auto;
CREATE DATABASE auto
USE auto;

CREATE TABLE listing (
  Id int(11) NOT NULL auto_increment,
  marka varchar(255) default NULL,
  model varchar(255) default NULL,
  price varchar(255) default NULL,
  additionalinfo varchar(255) default NULL,
  carcass varchar(255) default NULL,
  color varchar(255) default NULL,
  customs varchar(255) default NULL,
  gearbox varchar(255) default NULL,
  motorType varchar(255) default NULL,
  motorVolume varchar(255) default NULL,
  rudder varchar(255) default NULL,
  running varchar(255) default NULL,
  state varchar(255) default NULL,
  transmission varchar(255) default NULL,
  year varchar(255) default NULL,
  detailslink varchar(255) default NULL,
  oldId varchar(255) default NULL,
  listing_id int(11) default NULL,
  PRIMARY KEY  (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE owner (
  Id int(11) NOT NULL auto_increment,
  country varchar(255) default NULL,
  city varchar(255) default NULL,
  person varchar(255) default NULL,
  phone varchar(255) default NULL,
  email varchar(255) default NULL,
  PRIMARY KEY  (Id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;


CREATE TABLE photos (
  photo_id bigint(20) NOT NULL default 0,
  photos varchar(255) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;