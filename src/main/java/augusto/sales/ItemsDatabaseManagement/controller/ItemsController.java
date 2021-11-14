package augusto.sales.ItemsDatabaseManagement.controller;


import augusto.sales.ItemsDatabaseManagement.model.Items;
import augusto.sales.ItemsDatabaseManagement.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/items"})
public class ItemsController {

    private final ItemsService itemsService;

    @Autowired
    public ItemsController(final ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping({ "", "/" })
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Items> list(@RequestParam(required = false) final String item) {
        return this.itemsService.lisItem(item);
    }

    @GetMapping({ "/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Items get(@PathVariable(value="id") final Long id) {
        return this.itemsService.get(id);
    }

    @DeleteMapping({ "/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable(value="id") final Long id) {
        return this.itemsService.delete(id);
    }

    @PostMapping({ "", "/" })
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String save(@RequestBody final Items item){
        return this.itemsService.save(item);
    }

    @PutMapping({ "/{id}", "/{id}/"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Items update(@PathVariable(value="id") final Long id, @RequestBody final Items item) {
        return this.itemsService.update(id, item);
    }
}
