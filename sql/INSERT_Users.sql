INSERT INTO workflowengine.user(
   id
  ,email
  ,fullname
  ,agency
  ,confirmation_token
  ,password_hash
  ,date_creation
  ,date_password_remind
  ,date_remind
  ,validated
  ,role
  ,approved
  ,active
  ,userkey
  ,updated_by
  ,date_updated
) VALUES
(1, 'jdoe@google.com', 'John Doe', '', '', '$2a$10$2W044vxfKI3v2FEWNZ53KO7VWDzpTcw/dkqmSH4jqiJ1bCEby5rP6', NULL, NULL, NULL, 1, 1, NULL, 'Y', '123456', NULL, NULL), 
(2, 'dan.zeller@state.co.us', 'Dan Zeller', '', '', '$2a$10$2W044vxfKI3v2FEWNZ53KO7VWDzpTcw/dkqmSH4jqiJ1bCEby5rP6', NULL, NULL, NULL, 1, 3, NULL, 'Y', 'ABCDEF', NULL, NULL), 
(3, 'bob@google.com', 'Bob Johnson', '', '', '$2a$10$2W044vxfKI3v2FEWNZ53KO7VWDzpTcw/dkqmSH4jqiJ1bCEby5rP6', NULL, NULL, NULL, 1, 2, NULL, 'Y', '111111', NULL, NULL), 
(4, 'jane@google.com', 'Jane Doe', '', '', '$2a$10$2W044vxfKI3v2FEWNZ53KO7VWDzpTcw/dkqmSH4jqiJ1bCEby5rP6', NULL, NULL, NULL, 1, 1, NULL, 'Y', '222222', NULL, NULL)