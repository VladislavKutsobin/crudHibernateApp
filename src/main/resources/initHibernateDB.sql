USE HDB;

CREATE TABLE IF NOT EXISTS developers (
  id INT(11) AUTO_INCREMENT PRIMARY KEY,
  firstName VARCHAR(64),
  lastName VARCHAR(64),
  specialty VARCHAR(64)
  );

CREATE TABLE IF NOT EXISTS skills (
  id INT(11) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts (
  id INT(5) AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(64) NOT NULL
);

CREATE TABLE IF NOT EXISTS account_status (
  id INT(5) AUTO_INCREMENT PRIMARY KEY,
   acc_status VARCHAR(64) NOT NULL
   );

-- 
--
--
-- 						many to many 					--

CREATE TABLE IF NOT EXISTS developers_skills(
  developer_id INT NOT NULL ,
  skill_id INT NOT NULL ,
  PRIMARY KEY (developer_id , skill_id),
  FOREIGN KEY (developer_id) REFERENCES developers(id) on delete cascade,
  FOREIGN KEY (skill_id) REFERENCES skills(id) on delete cascade
);

  CREATE TABLE IF NOT EXISTS developers_accounts(
  developer_id INT NOT NULL ,
  account_id INT NOT NULL ,
  PRIMARY KEY (developer_id, account_id),
  FOREIGN KEY (developer_id) REFERENCES developers(id) on delete cascade,
  FOREIGN KEY (account_id) REFERENCES accounts(id) on delete cascade
  );

  --  many to many --> teams accounts + users status

  CREATE TABLE IF NOT EXISTS accounts_accstatus(
  acc_id INT NOT NULL ,
  status_id INT NOT NULL ,
  PRIMARY KEY (acc_id,status_id),
  FOREIGN KEY (acc_id) REFERENCES accounts(id) on delete cascade,
  FOREIGN KEY (status_id) REFERENCES account_status(id) on delete cascade
  );


