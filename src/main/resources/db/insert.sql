set foreign_key_checks=0;

truncate table product;
truncate table feedback;


insert into product(`id`, `name`, `price`,`details`, `currency`)
values(110,'luxury chair', 4500,'numquam blanditiis harum quisquam eius sed odit', 'FRC'),
(111, 'luxury sofa', 4500, 'numquam blanditiis harum quisquam eius sed odit', 'USD'),
(112, 'luxury bench', 6500, 'numquam blanditiis harum quisquam eius sed odit','NGN'),
(113, 'luxury table', 8500, 'numquam blanditiis harum quisquam eius sed odit', 'NGN');

set foreign_key_checks=1;