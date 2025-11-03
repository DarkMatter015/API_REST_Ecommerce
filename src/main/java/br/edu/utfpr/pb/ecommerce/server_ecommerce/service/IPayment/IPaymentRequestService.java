package br.edu.utfpr.pb.ecommerce.server_ecommerce.service.IPayment;

import br.edu.utfpr.pb.ecommerce.server_ecommerce.dto.payment.PaymentUpdateDTO;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.model.Payment;
import br.edu.utfpr.pb.ecommerce.server_ecommerce.service.ICRUD.ICrudRequestService;

public interface IPaymentRequestService extends ICrudRequestService<Payment, PaymentUpdateDTO, Long> {
}
