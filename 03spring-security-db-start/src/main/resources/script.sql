 
CREATE TABLE `users` (                  
          `username` varchar(50) NOT NULL,      
          `password` varchar(50) DEFAULT NULL,  
          `enabled` tinyint(1) DEFAULT NULL,    
          PRIMARY KEY (`username`)              
        )    


    CREATE TABLE `authorities` (            
               `username` varchar(50) DEFAULT NULL,  
               `authority` varchar(50) DEFAULT NULL  
             ) 
             
 insert into `users` values ('prasad','pass@123',1),('siva','pass@123',1),('way2learnindia@gmail.com','secret',1);

insert into `authorities` values ('siva','ROLE_ADMIN'),('siva','ROLE_EMPLOYEE'),('prasad','ROLE_ADMIN'),('way2learnindia@gmail.com','ROLE_USER');
        
   
             
CREATE TABLE `groups` (                                  
          `id` int(11) NOT NULL AUTO_INCREMENT,                  
          `group_name` varchar(50) NOT NULL,                     
          PRIMARY KEY (`id`)                                     
        ) 

CREATE TABLE `group_members` (                           
                 `id` int(11) NOT NULL AUTO_INCREMENT,                  
                 `username` varchar(50) NOT NULL,                       
                 `group_id` int(11) NOT NULL,                           
                 PRIMARY KEY (`id`)                                     
               ) 


CREATE TABLE `group_authorities` (      
                     `group_id` int(11) NOT NULL,          
                     `authority` varchar(50) NOT NULL      
                   ) 
                   
                   

 insert into `groups` values (1,'Users'),(2,'Administrators');
insert into `group_authorities` values (1,'ROLE_USER'),(2,'ROLE_USER'),(2,'ROLE_ADMIN');
insert into `group_members` values (1,'siva',1),(2,'prasad',2);