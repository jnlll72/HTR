package Project.Service;

import Project.DAO.MessageDAO;
import Project.Model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDAO messageDAO;

    @Override
    public long add(Message message) {
       return messageDAO.add(message);
    }
}
