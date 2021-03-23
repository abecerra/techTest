
SELECT  student_id, student_name
FROM student  
where student_id NOT IN
	(
	SELECT student_id FROM scores 
	WHERE subject_id IN
 	 (SELECT subject.subject_id 
 	  FROM subject 
 	  where subject_name = 'Math')
	);