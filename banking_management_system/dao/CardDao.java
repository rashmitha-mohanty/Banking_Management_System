package com.qsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.banking_management_system.dto.Card;
import com.qsp.banking_management_system.dto.Loan;
import com.qsp.banking_management_system.repo.CardRepo;

@Repository
public class CardDao {
	@Autowired
	CardRepo cardRepo;
	
	public Card saveCard(Card card) {
		return cardRepo.save(card);
	}
	
	public Card fetchCardById(int cardId) {
		Optional<Card> card = cardRepo.findById(cardId);
		if (card.isPresent()) {
			return card.get();
		} else {
			return null;
		}
	}
	
	public Card deleteCardById(int cardId) {
//		Card card=cardRepo.findById(cardId).get();
		Card card=fetchCardById(cardId);
		cardRepo.delete(card);
		return card;
	}
	
	public Card updateCard(int oldId,Card newCard) {
		newCard.setCardId(oldId);
//		return cardRepo.save(newCard);
		return saveCard(newCard);
	}
	
	public List<Card> fetchAllCard() {
		return cardRepo.findAll();
	}
}
