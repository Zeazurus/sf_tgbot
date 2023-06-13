package ru.skillfactorydemo.tgbot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.Spend;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class SpendRepositoryTest {

    @Autowired
    private SpendRepository spendRepository;

    @Test
    public void testRepo() {
        //noinspection StatementWithEmptyBody
        for (int i = 0; i < 10; i++, spendRepository.save(new Spend()));
        final List<Spend> found = spendRepository.findAll();
        assertEquals(13, found.size());
    }

    @Test
    public void testSpendSql() {
        Optional<Spend> income = spendRepository.findById(555L);
        assertTrue(income.isPresent());
        assertEquals(new BigDecimal("745.00"), income.get().getSpend());

        income = spendRepository.findById(443L);
        assertTrue(income.isPresent());
        assertEquals(new BigDecimal("2443.00"), income.get().getSpend());

        income = spendRepository.findById(21L);
        assertTrue(income.isPresent());
        assertEquals(new BigDecimal("111111.00"), income.get().getSpend());
    }
}