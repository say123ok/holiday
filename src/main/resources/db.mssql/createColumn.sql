USE TESTDB
GO

SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[t_holiday](
	[id] [bigint] NOT NULL,
	[created_datetime] [datetime2](7) NOT NULL,
	[edited_datetime] [datetime2](7) NOT NULL,
	[version] [int] NOT NULL,
	[holiday_ref] [varchar](50) NULL,
	[holiday_name] [varchar](255) NULL,
	[holiday_color] [varchar](50) NOT NULL,
	[holiday_capacity] [int] NOT NULL,	
PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO