package at.htl.workloads.person;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class PersonRepositoryImpl implements PersonRepository {

    private final EntityManager entityManager;

    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Person getPersonById(long id) {
        var query = entityManager.createQuery("select p from Person p where p.id = :id", Person.class);
        query.setParameter("id", id);
        return query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public void addPerson(Person person) {
        entityManager.persist(person);
    }

    @Override
    public List<Person> getAllPeople() {
        var query = entityManager.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }

    public void deletePerson(long id){
        var person = getPersonById(id);
        entityManager.remove(person);
    }

}
