create table guestbook  		no       number(),
						        name      varchar2(80),
						        password  varchar2(20),
						        content   varchar2(2000),
						        reg_date  date,
                                primary key (no); 
                                
/*ORA-00933: SQL command not properly ended
00933. 00000 -  "SQL command not properly ended"  문장끝이 이상함  */   
                                
                                
create table guestbook(  		no       number,
						        name      varchar2(80),
						        password  varchar2(20),
						        content   varchar2(2000),
						        reg_date  date
                                primary key (no)); 
/*ORA-00907: missing right parenthesis
00907. 00000 -  "missing right parenthesis" 콤마없어 이자식아 */
                                
                                

create table guestbook(  		no       number,
						        name      varchar2(80),
						        password  varchar2(20),
						        content   varchar2(2000),
						        reg_date  date,
                                primary key (no)); 
/*정상작동...하하.. */                                


                                
                                
select *
from guestbook;

create SEQUENCE seq_guestbook_no;

commit;
