
DROP TABLE IF EXISTS transactionresponse;
create table transactionresponse
(   id integer not null,
   transactionDate varchar(255) not null,
   transactionTime varchar(255) not null,
transactionType varchar(255) not null,
   patientFirstName varchar(255) not null,
patientLastName varchar(255) not null,
   payer varchar(255) not null,
serviceProvider varchar(255) not null,
   admissionDate varchar(255) not null,
facilityTypeCode varchar(255) not null,
   certificationActionCode varchar(255) not null,
reviewIdentificationNumber varchar(255) not null,
   reviewDecisionReasonCode varchar(255) not null,
   primary key(id)
);



