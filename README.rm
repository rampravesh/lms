# lms (loan management system)

#tables



create schema LoanManagementSystem;

CREATE TABLE `BaseInterestRates` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `LoanType` varchar(100),
  `BaseInterestRate` double(10),
  PRIMARY KEY (`Id`)
);


CREATE TABLE `LoanPlans` (
  `PlanId` int(10) NOT NULL AUTO_INCREMENT,
  `PlanName` varchar(30) DEFAULT NULL,
  `LoanTypeId` int(10) DEFAULT NULL,
  `PrincipleAmount` int(10) DEFAULT NULL,
  `Tenure` int(3) DEFAULT NULL,
  `InterestRate` float DEFAULT NULL,
  `InterestAmount` int(10) DEFAULT NULL,
  `TotalPayable` int(10) DEFAULT NULL,
  `EMI` float DEFAULT NULL,
  `PlanValidity` date DEFAULT NULL,
  `PlanAddedOn` date DEFAULT NULL,
  PRIMARY KEY (`PlanId`),
  KEY `FK_LoanTypeId` (`LoanTypeId`),
  CONSTRAINT `FK_LoanTypeId` FOREIGN KEY (`LoanTypeId`) REFERENCES `BaseInterestRates` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `LoanPlansHistory` (
  `Id` int(10) NOT NULL AUTO_INCREMENT,
  `UpdateDate` date DEFAULT NULL,
  `UpdateReason` varchar(500) DEFAULT NULL,
  `LoanPlanId` int(10) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_LoanPlanId` (`LoanPlanId`),
  CONSTRAINT `FK_LoanPlanId` FOREIGN KEY (`LoanPlanId`) REFERENCES `LoanPlans` (`PlanId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


swagger url
http://localhost:8080/api/swagger-ui.html

