package com.infinite.crm.task;

import java.util.Iterator;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import jakarta.ws.rs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/n1")
public class TaskController {

	@Autowired
	private TaskRepository repo;

	@PostMapping("/post")
	public Observable<Task> addTask(@RequestBody Task task) {
        return Observable.fromCallable(()->repo.save(task));
    }

	@GetMapping("/getall")
	public Observable<Task> getalltasks() {
		return Observable.fromIterable(repo.findAll());
	}
	
	@GetMapping("/getall/{name}")
	public Observable<Task> getalltasksbyname(@PathVariable String name){
		return Observable.fromIterable(repo.findAllByName(name));
	}
	
	@GetMapping("get/{id}")
	public Observable<Task> getTask(@PathVariable Integer id){
		return Observable.fromCallable(()->repo.findById(id).get());
	}
	
	@PutMapping("/put/{id}")
	public Observable<Task> updateTask(@RequestBody Task task,@PathVariable Integer id) {
		return Observable.fromCallable(()->repo.findById(id).map(t -> {
			t.setNumber(task.getNumber());
			t.setName(task.getName());
			return repo.save(t);
		}).get());
	}

	@DeleteMapping("delete/{id}")
	public void deleteTask(@PathVariable Integer id){
		repo.deleteById(id);
	}
}
