package com.example.project.service;

import com.example.project.entity.Transaction;
import com.example.project.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
    
    public Transaction updateid(Long id, Transaction transactionDetails) {
        if (transactionRepository.existsById(id)) {
            Transaction obj = transactionRepository.findById(id).get();
            obj.setId(id);
            obj.setAmount(transactionDetails.getAmount());
            obj.setDescription(transactionDetails.getDescription());
            obj.setDate(transactionDetails.getDate());
            return transactionRepository.save(obj);
        }
        return null;
    }

}
