use lekhabathikfactory;

Insert into Customer Values('C134','Nimal Karunathilaka','no.94,abc road,colombo 5','0712457896','930440884V');
Select cust_id From Customer order by cust_id desc limit 1;
Select * From customer where c_name like 'Gun%'  order by c_name limit 10;
Update Customer set c_name='Gunaratne',c_address='no.32,asd road,colombo 6',c_telephone='0715471896',c_nic='965545789V' where cust_id='C001' ;
Select * From customer where cust_id='C001';

Insert into CustomerOrder Values('Q0234','C001','G003','2016-05-23','45','12.00');
Update Garment set in_stock='2016-05-23' where garment_id='G003';
Select order_id From customerorder order by order_id desc limit 1;
Select * From customerorder where order_id like 'Q0%' and cust_id='C001' order by order_id limit 10;
Select * From customerorder where order_id='Q002';
Select order_id,dateoforder,sum(amount*unit_price) as order_price From customerorder where cust_id='C002' group by order_id;
Select sum(amount*unit_price) as order_price From customerorder where dateoforder like '2016-03-%';
Select sum(amount*unit_price) as order_price From customerorder where dateoforder like '2016%';

Update dailyclothusage set no_of_pieces='15',amount='15.6' where dateofuse='2016-03-21' and garment_id='G002' and mat_id='M011';
Insert into dailyclothusage Values('M011','G005','2016-05-30','16.3','20');
Select * From dailyclothusage where garment_id='G002' and dateofuse='2016-03-21' and mat_id='M011';
Select * From dailyclothusage  left join garment  using(garment_id) left join material  using(mat_id) where  dateofuse='2016-03-21' ;
Select mat_id,mat_name,garment_id,garment_name,sum(amount) as s_amount,sum(no_of_pieces) as s_pieces From dailyclothusage  left join garment  using(garment_id) left join material  using(mat_id) where  dateofuse='2016-03-%' group by garment_id;
Insert into daily_coverage Values('G001','2016-03-21','5','12','14','7','18','14');
Select * From daily_coverage where garment_id='G001' and dateofcover='2016-03-21';
Update daily_coverage set no_of_cut='16',no_of_sewn='14',no_of_dyed='13',no_of_washdry='13',no_of_sewfinish='14',no_of_finish='13' where dateofcover='2016-03-21' and garment_id='G001';
Select * From daily_coverage  left join garment  using(garment_id) where  dateofcover='2016-03-21' ;
Select garment_id,garment_name,sum(no_of_cut) as s_cut,sum(no_of_sewn) as s_sewn,sum(no_of_dyed) as s_dyed,sum(no_of_washdry) as s_washdry,sum(no_of_sewfinish) as s_sewfinish,sum(no_of_finish) as s_finish From daily_coverage  left join garment  using(garment_id) where  dateofcover like '2016-03-%'  group by garment_id;

Insert into dailymaterialusage values('M001','2016-05-30','154.32');
Update Material set  in_stock='4' where mat_id='M001';
Select * From dailymaterialusage where mat_id='M001' and dateofuse='2016-03-21';

Select * From empwage where emp_id='E001' and month='05' and year='2016';
Insert into empwage values('E001','01','2016','27','20','0','0','0','0') ;
Update empwage set  no_of_days='28',ot_hours='10' where emp_id='E001' and month='01' and year='2016';
Select * From empsalary where emp_id='E003' and month='05' and year='2016';
Select * From empwage where emp_id='E001' and month='05' and year='2016';

