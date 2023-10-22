package edu.hw2.Task3;

import edu.hw2.Task3.Connection.Connection;
import edu.hw2.Task3.Exception.ConnectionIsNotStableException;
import edu.hw2.Task3.Manager.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class PopularCommandExecutor {

    private final ConnectionManager manager;
    private final int maxAttempts = 20;
    private final static Logger LOGGER = LogManager.getLogger();

    PopularCommandExecutor(ConnectionManager manager) {
        this.manager = manager;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    private void tryExecute(String command) {
        for (int i = 1; i <= maxAttempts; i++) {
            try (Connection connection = manager.getConnection()) {
                connection.execute(command);
                break;
            } catch (ConnectionIsNotStableException e) {
                if (i == maxAttempts) {
                    throw new ConnectionIsNotStableException("> Exceeded the number of attempts!", e);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
