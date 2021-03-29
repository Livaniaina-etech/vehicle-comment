var token = null

showVehicles = async () => {
	let ul = document.querySelector('.listCtn')
	let request = await fetch('http://localhost:8085/vehicle/list', {
		mode: "cors",	
	})
	request.json().then(res => {
		console.log('res ... ', res)
		res.data.forEach(item => {
			let listItem = document.createElement('li')
			listItem.classList.add('item')
	
			let model = document.createElement('h3')
			model.innerHTML = item.model
	
			let brand = document.createElement('h5')
			brand.innerHTML = item.brand
	
			listItem.appendChild(model)
			listItem.appendChild(brand)
	
			token && showComment(item.id, listItem)
	
			ul.appendChild(listItem)
		})
	})

}

showComment = async (vehicle_id, container) => {
	//let comments = comments_data.filter(cm => cm.vehicle_id === vehicle_id) || []
	let comment = await fetch(`http://localhost:8085/comment/list?vehicleID=${vehicle_id}`, {
		mode: "cors",	
	})
	comment.json().then(comm => {
		if(comm.comments && comm.comments.length > 0){
			let div = document.createElement('div')
			let ul = document.createElement('ul')
			div.appendChild(ul)
			comm.comments.forEach(comm => {
				let list = document.createElement('li')
				list.classList.add('comment')
				list.innerHTML = comm.user.username+ ': ' +comm.commentData
				ul.appendChild(list)
			})
			container.appendChild(div)
		}	
	})

}

document.getElementById('login').addEventListener('click', async () => {
	let req = await fetch('http://localhost:8085/user/login', {
		method: 'POST',
       	mode: 'cors',
       	headers: {
			'Accept': 'application/json',
      		'Content-Type': 'application/json'
		},
       	body: JSON.parse(JSON.stringify({username:'userdefault',password:'PassUserDef'}))
	})
	console.log(req)
	req.json().then(r => {
		token = r.data.token
		showVehicles()
	})
})

showVehicles()