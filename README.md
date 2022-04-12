# Twitter Application ![](https://us-central1-progress-markdown.cloudfunctions.net/progress/100)


### Use cases:


#### User

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Login`
##### `Any request when user is not logged in => login form.`
##### `After login, please use swagger to test other requests!`
##### `User logged in until app is restarted or another login is made.`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Register`
##### Exceptions: `User already exists`, `Bad format`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Search`
##### Exceptions: `No user found`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Follow`
##### Exceptions: `Already followed`
##### Reminder: `Successfully followed`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Unfollow`
##### Exceptions: `Not followed`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Unregister`
##### Exceptions: `User not found`


#### Post

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Add post`
##### Exceptions: `Wrong post format`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Get own posts`
##### Exceptions: `Wrong date filter format`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Get feed`
##### Exceptions: `Something wrong while fetching feed`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Delete post`
##### Exceptions: `Post not found in user's list`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Repost`
##### Exceptions: `Post not found`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Get mentions`
##### Exceptions: `User not mentioned`


#### Like

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Like post`
##### Exceptions: `Post is already liked by current user`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Remove like`
##### Exceptions: `Post is not liked by current user`.

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Cascade`
##### `Done by foreign key cascading`


#### Reply

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Add post reply`
##### `Can add multiple replies to same post`

##### <img src="https://user-images.githubusercontent.com/41987455/158020467-fa54dd6e-8771-44f8-acce-f3a0a94c66c6.png" width="15" height="15"> `Cascade`
##### `Done by foreign key cascading`
