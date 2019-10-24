$(document).ready(function () {
	
	$('#scraping-form')[0].reset();
	
	$('#scraping-form').on('submit', function(e) {
		e.preventDefault();
		var tag = $('#tag')[0].value
		
		scrapMedium(tag);
	});
	
	function scrapMedium(tag) {
		$.ajax({
	        type: "GET",
	        url: "/api/blogs/scrap/" + tag,
	        success : function(result) {
	        	
	        	console.log(result)
	        	
	        	var tableBody='<br/>';
	        	var i=1;
	        	$.each(result.data, function(index, data) {
	        		tableBody += '<tr>';
	        		tableBody += '<td>'+ i +'</td>';
	        		
	        		tableBody += '<td>'+ data.title +'%</td>';
	        		tableBody += '<td>'+ data.creator+'</td>';
	        		tableBody += '<td>'+ data.details+'</td>';
	        		tableBody += '<td>'+ data.tag+'</td>';
	        		tableBody += '<td><a href="'+ data.blogLink  +'"> <span class="glyphicon glyphicon-share-alt"></span> link</a></td>';
	        		tableBody += '</tr>';
	        		i = i + 1;
	        	});
	        	
	        	$('#data-table-body').html(tableBody);
	        	$('#data-table').DataTable({ 
	        		"sort": false,
	        		"paging": true,
                    "destroy": true,
                    "aLengthMenu": [[10, 15, 25, 50, 75, -1], [10, 15, 25, 50, 75, "All"]],
                });
	        	
	        },
			error : function(e) {
				
			}
		});
	}
	
	
	
	
});