package at.htl.workloads.person;

import at.htl.workloads.AwesomePeopleCount;

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
    public Person getPersonById(String ssn) {
        var query = entityManager.createQuery("select p from Person p where p.SSN = :ssn", Person.class);
        query.setParameter("ssn", ssn);
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

    @Override
    public List<Object[]> getAllPeopleWithAddresses() {
        var query = entityManager.createQuery("select p.SSN,p.firstName,p.lastName,a.id,a.country,a.city,a.street,a.streetNo from Person p join Address a on a.id.person = p");
        return query.getResultList();
    }

    @Override
    public List<Object[]> getCityNames() {
        var query = entityManager.createQuery("select distinct a.city from Person p join p.addresses a where p.isAwesome = true order by a.city");
        return query.getResultList();
    }

    @Override
    public List<AwesomePeopleCount> getAwesomePeopleCount() {
        var query = entityManager.createQuery("select new at.htl.workloads.AwesomePeopleCount(p.isAwesome, count(p.SSN)) from Person p group by p.isAwesome",AwesomePeopleCount.class);
        return query.getResultList();
    }
}
