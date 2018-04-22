CREATE TABLE qa (
  name   VARCHAR(30) NOT NULL,
  vendor VARCHAR(30) NOT NULL,
  license VARCHAR(30) NOT NULL,
  rank INT NOT NULL
);

INSERT INTO qa
	(name,vendor,license,rank)
VALUES
        ("selenium","seleniumhq", "Apache", "1"),
        ("Quick Test Pro", "HP","proprietary", "3"),
        ("Watir", "unknown","MIT", "2");


CREATE TABLE mw (
  name   VARCHAR(30) NOT NULL,
  vendor VARCHAR(30) NOT NULL,
  license VARCHAR(30) NOT NULL,
  rank INT NOT NULL
);

INSERT INTO mw
	(name,vendor,license,rank)
VALUES
        ("Tomcat","Apache", "Apache", "1"),
        ("Weblogic", "Oracle","proprietary", "2"),
        ("JBoss", "Redhat","GNU LGPL", "3"),
	("Websphere", "IBM","proprietary", "4");


CREATE TABLE web (
  name   VARCHAR(30) NOT NULL,
  vendor VARCHAR(30) NOT NULL,
  license VARCHAR(30) NOT NULL,
  share	  VARCHAR(30) NOT NULL,
  rank INT NOT NULL
);

INSERT INTO web
	(name,vendor,license,share,rank)
VALUES
        ("Apache HTTPD","Apache", "Apache","38%", "1"),
        ("Nginx", "Nginx","2-clause BSD","16%", "2"),
        ("IIS", "Microsoft","Proprietary","31%", "3"),
	("Litespeed", "IBM","proprietary","5%","4");
  

CREATE TABLE cmt (
  name   VARCHAR(30) NOT NULL,
  writtenin VARCHAR(30) NOT NULL,
  license VARCHAR(30) NOT NULL,  
  rank INT NOT NULL
);

INSERT INTO cmt
	(name,writtenin,license,rank)
VALUES
        ("Kubernetes","Go", "Apache", "1"),
        ("Swarm", "Go","Apache", "2"),
        ("Mesos", "C++","Apache","3");
	
