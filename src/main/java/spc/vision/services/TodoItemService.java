package spc.vision.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spc.vision.models.*;
import spc.vision.repositories.TodoItemRepository;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public Optional<TodoItem> getById(Long id) {
        return todoItemRepository.findById(id);
    }

    public Iterable<TodoItem> getAll() {
        return todoItemRepository.findAll();
    }

    public List<TodoItem> findAllByOrderByIdDesc(){

        PageRequest pageRequest = PageRequest.of(0, 20, Sort.by(Sort.Direction.DESC, "id"));

        // Fetch the last 20 items from the repository
        Page<TodoItem> page = todoItemRepository.findAll(pageRequest);

        // Extract the content (items) from the page

        return page.getContent();

    }

    public TodoItem save(TodoItem todoItem) {


        if (todoItem.getId() == null) {
            todoItem.setStatusOfMeasurements(StatusOfMeasurements.MEASUREMENTS_NOT_STARTED);
            todoItem.setCreatedAt(Timestamp.from(Instant.now().truncatedTo(ChronoUnit.MINUTES)));

            return todoItemRepository.save(todoItem);
        }else if (!todoItem.getIsComplete()) {
            todoItem.setStatusOfMeasurements(StatusOfMeasurements.MEASUREMENTS_IN_PROGRESS);
            todoItem.setUpdatedAt(Timestamp.from(Instant.now().truncatedTo(ChronoUnit.MINUTES)));
            return todoItemRepository.save(todoItem);
        }else
            todoItem.setStatusOfMeasurements(StatusOfMeasurements.MEASUREMENTS_FINISHED);
        todoItem.setFinishedAt(Timestamp.from(Instant.now().truncatedTo(ChronoUnit.MINUTES)));

        long diff = todoItem.getFinishedAt().getTime() - todoItem.getCreatedAt().getTime();

        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;

        String minutes = String.valueOf(diffMinutes);
        String hours = String.valueOf(diffHours);
        String duration = hours + " - HOURS" + "  " + minutes + " - MINUTES";
        todoItem.setDuration(duration);

        return todoItemRepository.save(todoItem);
    }

    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }


    public Long countPartPack1(){
        return todoItemRepository.findAll().stream().filter(i-> i.getTypeOfPart().equals(TypeOfPart.MY21_Pack1)).count();
    }
    public Long countPartPack2(){
        return todoItemRepository.findAll().stream().filter(i-> i.getTypeOfPart().equals(TypeOfPart.MY21_Pack2)).count();

    }
    public Long countPartMY26(){
        return todoItemRepository.findAll().stream().filter(i-> i.getTypeOfPart().equals(TypeOfPart.MY26)).count();

    }

    public List<TodoItem> findLast20() {
        List<TodoItem> allItems = todoItemRepository.findAll();
        List<TodoItem> data = new ArrayList<>(allItems);

        long totalEntries = (long) data.size();
        long countLast20 = Math.min(20, totalEntries);

        return data.subList(Math.toIntExact(totalEntries - countLast20), Math.toIntExact(totalEntries));
    }

    public Long countMeasureNotStarted() {
        List<TodoItem> last20Items = findLast20();
        return last20Items.stream().filter(i -> i.getStatusOfMeasurements().equals(StatusOfMeasurements.MEASUREMENTS_NOT_STARTED)).count();
    }

    public Long countMeasureInPending() {
        List<TodoItem> last20Items = findLast20();
        return last20Items.stream().filter(i -> i.getStatusOfMeasurements().equals(StatusOfMeasurements.MEASUREMENTS_IN_PROGRESS)).count();
    }

    public Long countMeasureFinished() {
        List<TodoItem> last20Items = findLast20();
        return last20Items.stream().filter(i -> i.getStatusOfMeasurements().equals(StatusOfMeasurements.MEASUREMENTS_FINISHED)).count();
    }
}
