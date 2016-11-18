package com.ticket.mater.exception;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Test;

import com.ticket.master.exception.TicketMasterException;

public class TicketMasterExceptionTest {

	TicketMasterException exception = null;

    @Test
    public void test() {
        this.exception = new TicketMasterException("ERROR", new FileNotFoundException());
        assertEquals("ERROR", this.exception.getMessage());
    }
}
